(ns compojure-api-strong-coercions.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [compojure-api-strong-coercions.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[compojure-api-strong-coercions started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[compojure-api-strong-coercions has shut down successfully]=-"))
   :middleware wrap-dev})
