package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;
import hchaos.character.HChaos;
import hchaos.powers.SteadyPower;
import hchaos.util.CardStats;

public class SteadyAim extends BaseCard {
    public static final String ID = makeID(SteadyAim.class.getSimpleName());
        private static final CardStats info = new CardStats(
                HChaos.Enums.CARD_COLOR,
                CardType.SKILL,
                CardRarity.BASIC,
                CardTarget.SELF,
                1);


    public SteadyAim() {
        super(ID, info);
        setMagic(1, 1);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { // terrible workaround on 3rd line
        addToBot(new ApplyPowerAction(p, p, new SteadyPower(p, this.magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, -2)));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new LoseDexterityPower(AbstractDungeon.player, -2)));
    }

}
