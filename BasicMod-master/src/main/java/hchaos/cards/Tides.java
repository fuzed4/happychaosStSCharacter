package hchaos.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.CustomTags;
import hchaos.character.HChaos;
import hchaos.powers.GatheringShoresPower;
import hchaos.powers.TuningStatePower;
import hchaos.util.CardStats;

public class Tides extends BaseCard {

    public static final String ID = makeID(Tides.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            0
    );

    public Tides() {
        super(ID, info);
        setDamage(6, 3);
        setMagic(1, 1);

        tags.add(CustomTags.ELEMENTAL);
        tags.add(CustomTags.WATER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!p.hasPower(TuningStatePower.ID)){
            addToBot(new ApplyPowerAction(p, p, new TuningStatePower(p, 1)));
        }
        addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        addToBot(new ApplyPowerAction(p, p, new GatheringShoresPower(p, this.magicNumber)));
    }
}
