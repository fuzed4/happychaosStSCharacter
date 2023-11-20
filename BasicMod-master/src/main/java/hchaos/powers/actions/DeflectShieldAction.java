package hchaos.powers.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;

public class DeflectShieldAction extends AbstractGameAction {


    private AbstractMonster targetMonster;

    public DeflectShieldAction (int amount, AbstractMonster targetMonster) {
        this.actionType = ActionType.WAIT;
        this.duration = 0.00F;
        this.amount = amount;
        this.targetMonster = targetMonster;
    }

    @Override
    public void update() {
        if (this.targetMonster != null && this.targetMonster.getIntentBaseDmg() >= 0) {
            this.addToBot(new GainBlockAction(AbstractDungeon.player, this.amount));
        } else {
            AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 3.0F, "Not much of an attacker, are you?", true));
        }
        this.isDone = true;
    }

    }

