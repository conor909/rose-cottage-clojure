(ns clojure-proj.core
  (:require [reagent.core :as reagent]))

(enable-console-print!)

(defn canvas-component []
  [:canvas {:id "my-canvas" :style {:position "absolute"}} ]))

(defn header-component [props]
  (let [subHead (:subHead props) head (:head props)]
       [:div  {:style {:textAlign "center" :fontFamily "'Schoolbell', cursive" :color "#fff" :textShadow "0px 0px 10px #fff"}}
       [:div  {:style {:fontSize "2em"}} subHead]
       [:div  {:style {:fontSize "3em"}} head]]))

(defn app []
    [:div {:style {:position "relative" :height "100%" :background ["linear-gradient(180deg, #152b52 7%, #2c9ab3 51%, #f3f3d1 90%", "#f3f3d1"]}}
    [canvas-component]
    [header-component {:subHead "Welcome to" :head "Rose Cottage Playschool"}]])

(defn run []
  (reagent/render [app] (.getElementById js/document "app-container")))

(run)

(defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )

