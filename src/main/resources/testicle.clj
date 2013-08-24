(ns testicle
  (:require [vertx.http :as http]
            [vertx.core :as core]
            [vertx.eventbus :as eb]
            [cheshire.core :as json]))

(defn req-handler [req]
  (println "receiving request...")
  (eb/send "api.hello" {:message "hello from testicle"})
  (-> (http/server-response req)
    (http/add-header "Content-Type" "text/html; charset=UTF-8")
    (http/end (json/generate-string {:message "from json" :with "love"}))))

(let [server (http/server)]
  (http/on-request server req-handler)
  (http/listen server 8080 "localhost"))

;; throws java.lang.IllegalArgumentException, works when using core/deploy-verticle
(core/deploy-worker-verticle "testworker.clj")

(println "Starting Http server on localhost:8080")