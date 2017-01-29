(ns user
  (:require
   cljs.repl.node
   cemerick.piggieback
   [figwheel-sidecar.system :as sys]))

(defonce figwheel-system (atom nil))

(defn start-figwheel!
  "This starts the figwheel server and watch based auto-compiler."
  []
  (swap! figwheel-system (fn [sys]
                           (if sys
                             (do (.. System err (println "Figwheel already running!"))
                                 sys)
                             (sys/start-figwheel!))))
  nil)

(defn stop-figwheel!
  "Stop the figwheel server and watch based auto-compiler."
  []
  (swap! figwheel-system (fn [sys]
                           (if sys
                             (sys/stop-figwheel! sys)
                             (.. System err (println "Figwheel already running!")))
                           nil))
  nil)

(defn figwheel-cljs-repl
  "Launch a figwheel-integrated ClojureScript REPL that is connected to your
  build and host environment."
  []
  (sys/cljs-repl (:figwheel-system @figwheel-system)))

(defn cljs-repl
  "Start a node CLJS REPL (no figwheel support)."
  []
  (cemerick.piggieback/cljs-repl (cljs.repl.node/repl-env)))
