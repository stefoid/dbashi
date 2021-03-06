package com.dbash.presenters.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dbash.models.PresenterDepend;
import com.dbash.models.TouchEventProvider;
import com.dbash.platform.ImageView;
import com.dbash.platform.UIDepend;
import com.dbash.presenters.widgets.TabPresenter;
import com.dbash.util.Rect;

	public class AbilityTab extends TabPresenter {

		private AbilitySelectionListPresenter listPresenter;
		private ImageView abilityTabImage;

		public AbilityTab(PresenterDepend model, UIDepend gui, TouchEventProvider touchEventProvider, Rect tabArea, Rect bodyArea) {
			super(model, gui, touchEventProvider, tabArea, bodyArea);
			abilityTabImage = new ImageView(gui, "ABILITY_TAB_IMAGE", tabArea);
			backImageCurrent = new ImageView(gui, "ABILITY_TAB_ON_IMAGE", tabArea);
			backImageNotCurrent = new ImageView(gui, "ABILITY_TAB_OFF_IMAGE", tabArea);
			listPresenter = new  AbilitySelectionListPresenter(model, gui, touchEventProvider, bodyArea);
		}

		@Override
		public void setCurrent() {
			super.setCurrent();
			listPresenter.activate();
		}
		
		@Override
		public void unsetCurrent() {
			super.unsetCurrent();
			listPresenter.deactivate();
		}

		@Override
		public void drawTab(SpriteBatch spriteBatch, float x, float y) {
			// super will draw tab background (different for current/non current)
			super.drawTab(spriteBatch, x, y);
			abilityTabImage.draw(spriteBatch);
			
			if (shouldDrawBody) {
				listPresenter.draw(spriteBatch, x, y);
			}
		}
	}