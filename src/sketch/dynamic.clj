(ns sketch.dynamic
  (:require [quil.core :refer :all]))

(def size 90)

(defn draw []
  (no-loop)
  (color-mode :hsb 360 100 100 1.0)
  (stroke-weight 2)
  (background 220 49 30)
  (doseq [x (range size (- (width) size) size)
          y (range size (- (height) size) size)]
    (rect x y size size))
  (save "sketch.tif")
  (save "sketch.png"))
