(ns compojure-api-strong-coercions.routes.services
  (:require [ring.util.http-response :refer :all]
            [compojure.api.sweet :refer :all]
            [ring.swagger.coerce :refer [query-schema-coercion-matcher]]
            [schema.core :as s :refer [defschema]]))

(defschema User
  {:id s/Int
   :name s/Str})

(def strong-coercions
  (constantly
    (constantly query-schema-coercion-matcher)))

(defapi service-routes
  {:coercion strong-coercions
   :swagger {:ui "/swagger-ui"
             :spec "/swagger.json"
             :data {:info {:version "1.0.0"
                           :title "compojure api strong coercions"}}}}

  (context "/users" []
    (GET "/:id" []
      :path-params [id :- s/Str]
      :responses {200 {:schema User}}
      :summary "Strong coercions example"
      (ok {:id id
           :name "Eunmin Kim"}))))
