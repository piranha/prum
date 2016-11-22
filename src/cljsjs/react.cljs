(ns cljsjs.react
  (:require [preact.compat :as p]))

(set!
 js/React
 #js {"version" p/version
      "DOM" p/DOM
      "PropTypes" p/PropTypes
      "Children" p/Children
      "render" p/render
      "createClass" p/createClass
      "createFactory" p/createFactory
      "createElement" p/createElement
      "cloneElement" p/cloneElement
      "isValidElement" p/isValidElement
      "findDOMNode" p/findDOMNode
      "unmountComponentAtNode" p/unmountComponentAtNode
      "Component" p/Component
      "PureComponent" p/PureComponent
      "unstable_renderSubtreeIntoContainer" p/unstable_renderSubtreeIntoContainer})
