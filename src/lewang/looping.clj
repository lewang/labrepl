(ns lewang.looping)

(if-let [[first & rest] nil] "true" "false")
	;;; ⇒ "false"

(macroexpand '(if-let [[first & rest] result] "true" "false"))
	;;; ⇒ (let*
	;;;     [temp__3695__auto__ result]
	;;;     (if temp__3695__auto__
	;;;       (let [[first & rest] temp__3695__auto__] "true")
	;;;       "false"))

(defn min-1 [[min & tail]]
  (swank.core/break)
  (if-let [next (first tail)]
    (recur (conj
            (rest tail)
            (if (< next min)
              next
              min)))
    min))
	;;; ⇒ #'min-1

(min-1 [3 0 7])
	;;; ⇒ 0

(min-1 '(3 9 -1))
	;;; ⇒ -1
