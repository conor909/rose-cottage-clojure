(ns clojure-proj.canvas)

(defn fill-style [ctx color]
  (set! (.-fillStyle ctx) color))

(defn set-size [el [width height]]
  (set! (.-width el) width)
  (set! (.-height el) height))

(defn canvas []
  [:canvas {:id "my-canvas" :style {:position "absolute"}} ])

(defn draw-drop [x y]
  (let [target (.getElementById js/document "my-canvas") ctx (.getContext target "2d")]
    (.beginPath ctx)
    (.moveTo ctx  (+ x 100) y)
    (.lineTo ctx (+ x 145) (+ y 75))
    (.arc ctx (+ x 100) (+ y 75) 45 0 (* 1 Math/PI))
    (.moveTo ctx  (+ x 55) (+ x 75))
    (.lineTo ctx (+ x 100) y)
    (fill-style ctx "rgba(255, 255, 255, 0.5)")
    (.fill ctx)))