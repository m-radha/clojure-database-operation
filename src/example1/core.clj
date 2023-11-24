;; ;; (ns example1.core
;; ;;   (:gen-class))

;; ;; (defn -main
;; ;;   "I don't do a whole lot ... yet."
;; ;;   [& args]
;; ;;   (println "Hello, World!"))



;; (ns example1.core

;; (:require [clojure.java.jdbc :as jdbc]

;; [example1.db :as db]))

;; ;; (defn create-table []

;; ;; (jdbc/with-db-connection [db-conn db/db-spec]

;; ;; (jdbc/create-table db-conn

;; ;; :test-table

;; ;; [:id "SERIAL PRIMARY KEY"]

;; ;; [:name "VARCHAR"])))




;; (defn insert-data [name]

;; (jdbc/with-db-connection [db-conn db/db-spec]

;; (jdbc/insert! db-conn

;; :test-table

;; {:name name})))

;; (defn query-data []

;; (jdbc/with-db-connection [db-conn db/db-spec]

;; (jdbc/query db-conn ["SELECT * FROM test_table"])))

;; (defn -main [& args]

;; ;; Initialize the database and create the table

;;   (db/create-table)

;; ;; Insert data into the table

;;   (db/insert-data "John Doe")

;;   (db/insert-data "Jane Doe")

;; ;; Query and print data

;;   (let [data (db/query-data)]

;;     (doseq [row data]

;;       (println (str "ID: " (:id row) ", Name: " (:name row))))))


(ns example1.core
  (:require [clojure.java.jdbc :as jdbc]))

(defn -main []
  (let [mysql-db {:subprotocol "mysql"
                  :subname "//127.0.0.1:3306/TESTDB"
                  :user "root"
                  :password "Sathyabama@123"}]
    (try
      (let [result (jdbc/query mysql-db ["select * from EMPLOYEE"])]
        (println "Query successfully executed. Result:")
        (println result))
      (catch Exception e
        (println "Database query failed with exception:")
        (println (.getMessage e))))))


