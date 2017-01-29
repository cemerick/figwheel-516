(ns foo.bar
  (:require [reagent.core :as r]
            react-draggable))

(def Draggable (r/adapt-react-class js/ReactDraggable))

(defn on-js-reload []
  (println "reloaded"))
