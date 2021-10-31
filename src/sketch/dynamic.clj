(ns sketch.dynamic
  (:require [quil.core :refer :all]))

(def size 50)
(def displacement (/ size 2))
(def rotate-multiplier (/ size 2/3))
(def offset (/ size 3))
(def border (* size 5))

(defn plus-or-minus []
  (if (> 0.5 (random 0 1))
    -1
    1))

(defn translate-amount [y w]
  (* (/ y w) (plus-or-minus) (random 0 1) displacement))

(defn rotate-amount [y w]
  (* (/ y w) (/ PI 180) (plus-or-minus) (random 0 1) rotate-multiplier))

(defn random-color []
  (let [g (random-gaussian)]
    (cond
      (< g 0.3) (fill 220 49 30)
      (> g 0.7) (fill 220 80 80)
      :else (fill 40 100 80))))

(defn draw []
  (no-loop)
  (color-mode :hsb 360 100 100 1.0)
  (stroke-weight 2)
  (background 220 49 30)
  (doseq [x (range border (- (width) border) size)
          y (range border (- (height) border) size)]
    (push-matrix)
    (translate (+ x (translate-amount y (width)) offset) (+ y offset))
    (rotate (rotate-amount y (width)))
    (random-color)
    (rect (/ (- size) 2) (/ (- size) 2) size size)
    (pop-matrix))
  (save "sketch.tif")
  (save "sketch.png"))
