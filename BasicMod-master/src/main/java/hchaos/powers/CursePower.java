package hchaos.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import hchaos.powers.actions.CurseExplodeAction;

import static hchaos.HChaos.makeID;

public class CursePower extends BasePower {
    public static final String ID = makeID("Cursed");
    private static final AbstractPower.PowerType type = PowerType.DEBUFF;
    public AbstractPlayer p;

    public CursePower(AbstractCreature owner, int amount) {
        super(ID, type, false, owner, amount);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }

    @Override
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
    }

    public void atStartOfTurn() {

        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT && !AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flashWithoutSound();
            this.addToBot(new CurseExplodeAction(this.owner, this.source, this.amount, AbstractGameAction.AttackEffect.NONE));
            this.amount -= 5;
            if (AbstractDungeon.player.hasPower(GrudgePower.ID)) {
                if (this.amount <= 7) {
                    this.amount = 7;
                }
            }
            if (this.amount <= 0) {
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, CursePower.ID));
            }
        }
    }
}
