package com.nsfl.gocrush.DBLayer;

import com.nsfl.gocrush.ApplicationLayer.Error.DbError;
import com.nsfl.gocrush.Utility.SQLConfig;
import com.nsfl.gocrush.ModelLayer.Crush;
import java.sql.*;
import java.util.ArrayList;

public class CrushSQLRepository extends CrushRepository {

    private Statement stat;
    private ResultSet rs;

    public CrushSQLRepository() {
        try {
            SQLConfig config = SQLConfig.getInstance();
            System.out.println("Database connection established");
            stat = config.con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Crush addCrush(Crush crush) throws DbError {
        try {

            String insert = "INSERT INTO crush(appUserID,fbCrushID) VALUES('" + crush.getAppUserID() + "','" + crush.getfbCrushID() + "')";
            stat.executeUpdate(insert);
        } catch (Exception e) {
            throw new DbError(e.getMessage());
        }
        return crush;
    }

    @Override
    public Crush deleteCrush(Crush crush) throws DbError {
        try {
            String delete = "DELETE FROM crush WHERE appUserID = '" + crush.getAppUserID() + "' AND fbCrushID = '" + crush.getfbCrushID() + "'";
            stat.executeUpdate(delete);
        } catch (Exception e) {
            throw new DbError(e.getMessage());
        }
        return crush;
    }

    @Override
    public ArrayList<Crush> getCrushesByUserAppID(String id) {
        try {
            String query = "SELECT * FROM crush WHERE appUserID='" + id + "'";
            rs = stat.executeQuery(query);
            ArrayList<Crush> crushes = new ArrayList<>();
            while (rs.next()) {
                String appUserID = rs.getString("appUserID");
                String fbCrushID = rs.getString("fbCrushID");
                Crush crush = new Crush(appUserID, fbCrushID);
                crushes.add(crush);
            }
            return crushes;

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }

    @Override
    public int getNumberOfCrushesByUserAppID(String id) {
        try {
            String query = "SELECT COUNT(fbCrushID) FROM crush WHERE appUserID='" + id + "'";
            rs = stat.executeQuery(query);
            while (rs.next()) {

                int crushes = rs.getInt("count(fbCrushID)");
                return crushes;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int getNumberOfCrushesOnUser(String appUserID) {
        try {
            String query = "SELECT COUNT(*) FROM crush WHERE fbCrushID IN (SELECT fbUserID FROM user WHERE appUserID = '" + appUserID + "')";
            rs = stat.executeQuery(query);
            while (rs.next()) {

                int crushes = rs.getInt("count(*)");
                return crushes;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
