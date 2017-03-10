(ns compojure-api-strong-coercions.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[compojure-api-strong-coercions started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[compojure-api-strong-coercions has shut down successfully]=-"))
   :middleware identity})
