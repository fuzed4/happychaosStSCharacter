package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;
import hchaos.CustomTags;
import hchaos.character.HChaos;
import hchaos.powers.TuningStatePower;
import hchaos.util.CardStats;

import java.util.Iterator;

public class Swirl extends BaseCard {

    public static final String ID = makeID(Swirl.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );

    public Swirl() {
        super(ID, info);
        setBlock(6, 4);
        setMagic(1,1);

        tags.add(CustomTags.ELEMENTAL);
        tags.add(CustomTags.WIND);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!p.hasPower(TuningStatePower.ID)){
            addToBot(new ApplyPowerAction(p, p, new TuningStatePower(p, 1)));
        }

        addToBot(new GainBlockAction(p, p, this.block));

        AbstractMonster mon;
        Iterator var1 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

        while (var1.hasNext()) {
            mon = (AbstractMonster) var1.next();
            addToBot(new ApplyPowerAction(mon, p, new WeakPower(p, this.magicNumber, false)));
        }
    }
}
