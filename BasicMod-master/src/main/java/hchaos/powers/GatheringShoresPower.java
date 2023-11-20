package hchaos.powers;


import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.deprecated.DEPRECATEDTorrent;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import hchaos.cards.Torrent;

import static hchaos.HChaos.makeID;

public class GatheringShoresPower extends BasePower {

    public static final String ID = makeID("GatheringShores");
    private static final PowerType type = PowerType.BUFF;

    public GatheringShoresPower(AbstractCreature owner, int amount) {
        super(ID, type, true, owner, amount);
    }
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        if (this.amount >= 3){
            this.amount -= 3;
            addToBot(new MakeTempCardInHandAction(new Torrent(), 1));
        }
        if (this.amount == 0){
            addToBot(new RemoveSpecificPowerAction(AbstractDungeon.player, AbstractDungeon.player, GatheringShoresPower.ID));
        }
    }

}
