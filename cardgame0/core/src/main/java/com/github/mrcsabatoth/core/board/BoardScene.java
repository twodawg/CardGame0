package com.github.mrcsabatoth.core.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.mrcsabatoth.core.AppScene;

import static playn.core.PlayN.*;

import playn.core.CanvasImage;
import playn.core.GroupLayer;
import playn.core.ImageLayer;
import playn.core.Pointer;
import playn.core.Sound;

public class BoardScene extends AppScene {

    private GroupLayer layer;
    private List<PlayCard> cards = new ArrayList<PlayCard>(0);
    private Sound ding;
    private Sound cannery;

	@Override
	public String name() {
	  return "Play";
	}

	@Override
	public void init() {
      // create and add background image layer
      layer = graphics().createGroupLayer();
      graphics().rootLayer().add(layer);
            
      // load a sound that we'll play when placing sprites
      ding = assets().getSound("sounds/ding");
      
      cannery = assets().getSound("sounds/Cannery");
      cannery.setVolume(.25f);
      cannery.play();

      // draw a green flat background
      CanvasImage bgtile = graphics().createImage(64, 64);
      bgtile.canvas().setFillColor(0xFF5da52e);
      bgtile.canvas().fillRect(0, 0, 64, 64);
      bgtile.canvas().setStrokeColor(0xFF39611e);
      bgtile.canvas().strokeRect(0, 0, 64, 64);
      bgtile.setRepeat(true, true);

      ImageLayer bg = graphics().createImageLayer(bgtile);
      bg.setWidth(graphics().width());
      bg.setHeight(graphics().height());
      layer.add(bg);

      // add a listener for pointer (mouse, touch) input
      pointer().setListener(new Pointer.Adapter() {
        @Override
        public void onPointerEnd(Pointer.Event event) {
          ding.play();
        }
      });

      /*Random rnd = new Random();
      rnd.setSeed(11223344L);
      for(int bx = 0; bx < 5; bx++) {
        for(int by = 0; by < 5; by++) {
          CardSuit rndSuit = CardSuit.getValueFromInt(rnd.nextInt(4));
          CardValue rndValue = CardValue.getValueFromInt(rnd.nextInt(13));
          addCard(128 + bx * 64, 64 + by * 64, rndSuit, rndValue);
        }
      }*/
      Deck singledeck = new Deck();
      singledeck.shuffle();
      for(int bx = 0; bx < 5; bx++) {
          for(int by = 0; by < 5; by++) {
        	  Card card = singledeck.dealCard();
        	  addCard(128 + bx * 64, 64 + by * 64, card.getSuit(), card.getValue());
		  }
		}
	
      /*addCard(300f, 128f, CardSuit.SUIT_SPADE, CardValue.VALUE_A);
      addCard(364f, 128f, CardSuit.SUIT_SPADE, CardValue.VALUE_2);
      addCard(428f, 128f, CardSuit.SUIT_SPADE, CardValue.VALUE_3);
      
      addCard(300f, 192f, CardSuit.SUIT_SPADE, CardValue.VALUE_A);
      addCard(364f, 192f, CardSuit.SUIT_SPADE, CardValue.VALUE_2);
      addCard(428f, 192f, CardSuit.SUIT_SPADE, CardValue.VALUE_3);      
      
      addCard(300f, 300f, CardSuit.SUIT_DIAMOND, CardValue.VALUE_A);
      addCard(364f, 300f, CardSuit.SUIT_DIAMOND, CardValue.VALUE_2);
      addCard(428f, 300f, CardSuit.SUIT_DIAMOND, CardValue.VALUE_3);
      
      addCard(300f, 364f, CardSuit.SUIT_HEART, CardValue.VALUE_Q);
      addCard(364f, 364f, CardSuit.SUIT_HEART, CardValue.VALUE_K);
      addCard(428f, 364f, CardSuit.SUIT_HEART, CardValue.VALUE_A);*/
	}

    private void addCard(float x, float y, CardSuit suit, CardValue value) {
      PlayCard card = new PlayCard(layer, x, y, suit, value);
      cards.add(card);
    }

	@Override
	public void shutdown() {
      layer.destroy();
      layer = null;
    }
}
