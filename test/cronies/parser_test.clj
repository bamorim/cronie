(ns cronies.parser-test
  (:require [clojure.test :refer :all]
            [cronies.parser :refer :all]))

(deftest a-test
  (testing "Extract info."
    (is (= {:start "*" :end nil :step nil}
           (first (parse "* * * * *"))))))
