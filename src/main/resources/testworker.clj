(ns testworker
  (:require [vertx.eventbus :as eb]))

(defn msg-handler
  [message]
  (println "Message from testicle")
  (println message))

(eb/on-message "api.hello" msg-handler)
