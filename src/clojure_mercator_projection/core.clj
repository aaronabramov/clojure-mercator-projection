(ns clojure-mercator-projection.core)

(def r-major "Equatorial Radius, WGS84" 6378137.0)

(def r-minor 6356752.314245179)

(def f (/ 1 (/ (- r-major r-minor) r-major)))

(defn deg->rad
  "convert degrees to radians"
  [degree]
  (* degree (/ (. Math PI) 180)))


(defn -main []
  (println (deg->rad 144)))

