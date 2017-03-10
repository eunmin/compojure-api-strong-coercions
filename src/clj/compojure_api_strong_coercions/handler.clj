(ns compojure-api-strong-coercions.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [compojure-api-strong-coercions.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [compojure-api-strong-coercions.env :refer [defaults]]
            [mount.core :as mount]
            [compojure-api-strong-coercions.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    #'service-routes
    (route/not-found
      "page not found")))


(defn app [] (middleware/wrap-base #'app-routes))
