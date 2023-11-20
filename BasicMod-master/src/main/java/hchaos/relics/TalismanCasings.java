package hchaos.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import hchaos.cards.Blast;
import hchaos.character.HChaos;
import hchaos.powers.CursePower;

import static hchaos.HChaos.makeID;

public class TalismanCasings extends BaseRelic {
    private static final String NAME = "TalismanCasings";

    public static final String ID = makeID(NAME);

    private static final RelicTier RARITY = RelicTier.BOSS;

    private static final LandingSound SOUND = LandingSound.CLINK;

    public TalismanCasings(){
        super(ID, NAME, HChaos.Enums.CARD_COLOR, RARITY, SOUND);
    }

    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        if (c instanceof Blast) {
            addToBot(new ApplyPowerAction(m, AbstractDungeon.player, new CursePower(m, 2)));
        }
    }
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}