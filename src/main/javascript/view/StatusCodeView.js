'use strict';

SwaggerUi.Views.StatusCodeView = Backbone.View.extend({
  initialize: function (opts) {
    this.options = opts || {};
    this.router = this.options.router;
  },

  render: function(){
    $(this.el).html(Handlebars.templates.status_code(this.model));
    
    if (this.model.responseModel) {
        var value = this.router.api.models[this.model.responseModel];
        var responseSignatureView = new SwaggerUi.Views.SignatureView({
           model: this.model.responseModel,
           router: this.router,
           tagName: 'div',
           type: "Response",
           id: this.parentId + '_' + this.nickname + '_response'
         });
        $('.model-signature', $(this.el)).append(responseSignatureView.render().el);
    }
    
    return this;
  }
});