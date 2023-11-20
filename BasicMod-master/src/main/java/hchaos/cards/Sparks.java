package hchaos.cards;

import basemod.helpers.BaseModCardTags;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.CustomTags;
import hchaos.character.HChaos;
import hchaos.powers.TuningStatePower;
import hchaos.util.CardStats;

public class Sparks extends BaseCard {

    public static final String ID = makeID(Sparks.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public Sparks() {
        super(ID, info);
        setDamage(9,3);
        setMagic(2,3);

        tags.add(CustomTags.ELEMENTAL);
        tags.add(CustomTags.FIRE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!p.hasPower(TuningStatePower.ID)){
            addToBot(new ApplyPowerAction(p, p, new TuningStatePower(p, 1)));
        }
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }
}
