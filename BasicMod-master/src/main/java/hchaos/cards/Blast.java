package hchaos.cards;

import basemod.helpers.VfxBuilder;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import hchaos.character.HChaos;
import hchaos.powers.SteadyPower;
import hchaos.util.CardStats;

public class Blast extends BaseCard {
    public static final String ID = makeID(Blast.class.getSimpleName());
    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.SPECIAL,
            CardTarget.ENEMY,
            0
    );

    private static final int DAMAGE = 4;

    public Blast() {
        super(ID, info);
        setExhaust(true, true);
        setDamage(4, 3);
        }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.hasPower(SteadyPower.ID)) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
            addToBot(new ApplyPowerAction(p, p, new SteadyPower(p, -1)));
        } else {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
    }
}


