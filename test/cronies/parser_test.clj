(ns cronies.parser-test
  (:require [clojure.test :refer :all]
            [cronies.parser :refer :all]))

(deftest a-test
  (testing "Extract info."
    (is (= {:start "*" :end nil :step nil}
           (first (parse-cron "* * * * *"))))))

(deftest condp-test
  (testing "conditional regex function"
    (is (= {:start "2" :end "39" :step nil}
           (parse-term "2-39")))
    (is (= {:start "10" :end nil :step nil}
           (parse-term "10")))
    (is (= {:start "12" :end "59" :step "2"}
           (parse-term "12-59/2")))
    (is (= {:start "12" :end nil :step "2"}
           (parse-term "12/2")))
    (is (= {:start "*" :end nil :step nil }
           (parse-term "*")))
    (is (= {:start "*" :end nil :step "4"}
           (parse-term "*/4")))))
