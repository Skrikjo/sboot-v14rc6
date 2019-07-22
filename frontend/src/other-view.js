import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class OtherView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                }
            </style>
<vaadin-button theme="primary" id="setNameBtn">
  Sent name to john 
</vaadin-button>
<vaadin-button theme="primary success" id="goodBtn">
 GOOD! 
</vaadin-button>
<vaadin-button theme="primary" id="badBtn" on-click="handleClick">
 bad! 
</vaadin-button>
<h3>That is an other view for : [[name]] !</h3>
<input type="text" id="text">
`;
    }

    static get is() {
        return 'other-view';
    }

    static get properties() {
        return {
           name: {
               type: String,
               value: 'Daniel'
           }
            // Declare your properties here.
        };
    }

    ready() {
        super.ready();

    }

    handleClick() {
        console.warn('getText(): ' + this.getText());

    }


    getText() {
        this.name = this.$.text.value;
        console.warn('getText is called and will return: ' + this.$.text.value);
        return this.$.text.value;
    }
}

customElements.define(OtherView.is, OtherView);
