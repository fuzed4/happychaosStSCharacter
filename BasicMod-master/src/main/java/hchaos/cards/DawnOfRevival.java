package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import hchaos.character.HChaos;
import hchaos.util.CardStats;

import java.util.Iterator;

public class DawnOfRevival extends BaseCard {

    public static final String ID = makeID(DawnOfRevival.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF_AND_ENEMY,
            2
    );

    public DawnOfRevival() {
        super(ID, info);
        setMagic(4, 1);
        setExhaust(true, true);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        Iterator var1 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while (var1.hasNext()){
            m = (AbstractMonster)var1.next();
            addToBot(new ApplyPowerAction(m, p, new WeakPower(p, 5, false)));
            addToBot(new ApplyPowerAction(m, p, new VulnerablePower(p, 5, false)));
        }

        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new WeakPower(p, 5, false)));
        addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, 5, false)));
    }
}
