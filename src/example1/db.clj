(ns example1.db

  (:require [clojure.java.jdbc :as jdbc]))

;; db spec
(def db-spec

  {:classname "org.h2.Driver"

   :subprotocol "h2:mem"

   :subname "test-db"})