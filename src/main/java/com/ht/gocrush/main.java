package com.ht.gocrush;

import spark.*;
import static spark.Spark.*;

public class main {

  public static void main(String[] args) {
    get("/", (Request req, Response res) -> {
      return "Hello world!";
    });
  }
  
}
