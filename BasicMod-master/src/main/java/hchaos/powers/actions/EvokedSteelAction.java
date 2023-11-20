package hchaos.powers.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import hchaos.cards.Railpiercer;

public class EvokedSteelAction extends AbstractGameAction {


    private boolean isUpgraded;

    public EvokedSteelAction(boolean upgraded){
        this.target = AbstractDungeon.player;
        this.actionType = ActionType.WAIT;
        this.duration = Settings.ACTION_DUR_FAST;
        this.isUpgraded = upgraded;

    }

    @Override
    public void update() {
        //discard hand
        int count = AbstractDungeon.player.hand.size();

        if (this.isUpgraded) {
            this.addToTop(new DiscardAction(this.target, this.target, count, true));
        } else if (count != 0) {
            this.addToTop(new DiscardAction(this.target, this.target, count, true));
        }

        // gun
        Railpiercer r = new Railpiercer();
        if (isUpgraded = true){
            r.upgraded = true;
            this.addToBot(new MakeTempCardInHandAction(r, 1));
        } else {
            r.upgraded = false;
            this.addToBot(new MakeTempCardInHandAction(r, 1));
        }


        this.isDone = true;
    }
}

