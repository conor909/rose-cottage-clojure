(ns clojure-proj.canvas)

(def canvas (.getElementById js/document "my-canvas"))
(def ctx (.getContext canvas "2d"))

(defn fill-style [ctx color]
  (set! (.-fillStyle ctx) color)
)

(defn init-canvas
  []
  (set! (.-width canvas) (.-innerWidth js/window) )
  (set! (.-height canvas) (.-innerWidth js/window)))

(defn draw-drop [x y]
  (.beginPath ctx)
  (.moveTo ctx  (+ x 100) y)
  (.lineTo ctx (+ x 145) (+ y 75))
  (.arc ctx (+ x 100) (+ y 75) 45 0 (* 1 Math/PI))
  (.moveTo ctx  (+ x 55) (+ x 75))
  (.lineTo ctx (+ x 100) y)
  (fill-style ctx "rgba(255, 255, 255, 0.5)")
  (.fill ctx)
  )

(defn make-it-raaiiin [x y]
  (loop [x 1000]
    (when (> x 1)
      (draw-drop x y)
      (recur (- x 100))))
)