/**
 * @externs
 */

/**
 * @type {!Object}
 */
var preact = {};

preact.h = function(nodeName, attributes) {};

preact.cloneElement = function(vnode, props) {};

preact.render = function(vnode, parent, merge) {};

preact.rerender = function() {};

/**
 * @type {Object}
 */
preact.options = {};

/**
 * @type {Boolean}
 */
preact.options.syncComponentUpdates;

preact.options.vnode = function(vnode) {};

preact.options.afterMount = function(component) {};

preact.options.afterUpdate = function(component) {};

preact.options.beforeUnmount = function(component) {};

/**
 * @interface
 */
preact.Component = function(props, context) {};

preact.Component.prototype.shouldComponentUpdate = function() {};

preact.Component.prototype.linkState = function() {};

preact.Component.prototype.setState = function() {};

preact.Component.prototype.forceUpdate = function() {};

preact.Component.prototype.render = function() {};
