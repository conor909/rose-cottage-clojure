(ns clojure-proj.core
  (:require [reagent.core :as reagent]
            [clojure-proj.canvas :as canvas]))

(enable-console-print!)

(defn header-component [props]
  (let [subHead (:subHead props) head (:head props)]
       [:div  {:style {:textAlign "center" :fontFamily "'Schoolbell', cursive" :color "#fff" :textShadow "0px 0px 10px #fff"}}
       [:div  {:style {:fontSize "2em"}} subHead]
       [:div  {:style {:fontSize "3em"}} head]]))

(defn canvas []
  [:canvas {:id "my-canvas" :style {:position "absolute"}} ])

(defn draw-drop []
  (let [target (.getElementById js/document "my-canvas") ctx (.getContext target "2d")]
    (.beginPath ctx)
    (.moveTo ctx  100 0)
    (.lineTo ctx 145 75)
    (.arc ctx 100 75 45 0 (* 1 Math/PI))
    (.moveTo ctx  55 75)
    (.lineTo ctx 100 0)
    (canvas/fill-style ctx "rgba(255, 255, 255, 0.5)")
    (.fill ctx)))

(defn app []
    [:div {:style {:position "relative" :height "100%" :background ["linear-gradient(180deg, #152b52 7%, #2c9ab3 51%, #f3f3d1 90%", "#f3f3d1"]}}
    [canvas]
    [header-component {:subHead "Welcome to" :head "Rose Cottage"}]])

(defn run []
  (reagent/render [app] (.getElementById js/document "app-container")))

(run)
(draw-drop [])

(defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )

