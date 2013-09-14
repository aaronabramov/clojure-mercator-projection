(ns clojure-mercator-projection.core-test
  (:require [clojure.test :refer :all]
            [clojure-mercator-projection.core :refer :all]))

(deftest deg->rad-test
  (testing "converts degrees to radians"
    (is (= (deg->rad 144) 2.5132741228718345))))
