(ns prum.core
  (:require [rum.core :as rum]))

(rum/defc Header < rum/static [text]
  [:header
   [:h1 text]])

(rum/defc Button [props child]
  [:button props child])

(rum/defcs Counter <
  rum/static
  (rum/local 0 ::state)
  [{state ::state}]
  [:div
   (Button {:on-click #(swap! state dec)}
           "-")
   [:span {:style {:margin "0 16px"}}
    @state]
   (Button {:on-click #(swap! state inc)}
           "+")])

(rum/defc Input [{:keys [value on-change]}]
  [:input {:style {:padding "4px 8px"
                   :border-radius 2
                   :border "1px solid #141414"}
           :value value
           :on-change #(on-change (.. % -target -value))}])

(rum/defcs App <
  (rum/local {:text "Hello, world!"} ::state)
  [{state ::state}]
  (let [{:keys [text]} @state]
    [:div.container {:style {:font "normal 16px sans-serif"}}
     (Header "Preact + Rum")
     [:main.content
      (Counter)
      [:div {:style {:margin "10 0"}}
       [:p text]
       (Input {:value text
               :on-change #(swap! state assoc :text %)})]]]))

(rum/mount
 (App)
 (js/document.getElementById "app"))
