package hchaos.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.watcher.ExpungeVFXAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

import static hchaos.powers.ConcentrationPower.amount;

public class Railpiercer extends BaseCard {

    public static final String ID = makeID(Railpiercer.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.SPECIAL,
            CardTarget.ENEMY,
            1
    );


    public Railpiercer() {
        super(ID, info);
        setDamage(6, 2);
        setMagic(3,  1);
        setExhaust(false, false);
        isMagicNumberModified = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            this.addToBot(new ExpungeVFXAction(m));
            this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage * this.magicNumber, this.damageTypeForTurn), AbstractGameAction.AttackEffect.NONE));
    }
}
