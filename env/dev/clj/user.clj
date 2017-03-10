(ns user
  (:require [mount.core :as mount]
            compojure-api-strong-coercions.core))

(defn start []
  (mount/start-without #'compojure-api-strong-coercions.core/http-server
                       #'compojure-api-strong-coercions.core/repl-server))

(defn stop []
  (mount/stop-except #'compojure-api-strong-coercions.core/http-server
                     #'compojure-api-strong-coercions.core/repl-server))

(defn restart []
  (stop)
  (start))


