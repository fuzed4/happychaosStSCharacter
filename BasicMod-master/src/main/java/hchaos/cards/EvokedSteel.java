package hchaos.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;
import hchaos.character.HChaos;
import hchaos.powers.actions.EvokedSteelAction;
import hchaos.util.CardStats;

public class EvokedSteel extends BaseCard {

    public static final String ID = makeID(EvokedSteel.class.getSimpleName());

    private static final CardStats info = new CardStats(
            HChaos.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            0
    );

    public EvokedSteel() {
        super(ID, info);
        this.cardsToPreview = new Railpiercer();
        setExhaust(true, true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new VigorPower(p, AbstractDungeon.player.hand.size())));
        this.addToBot(new EvokedSteelAction(false));

    }
}

