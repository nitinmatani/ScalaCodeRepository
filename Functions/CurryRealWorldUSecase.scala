object CurryRealWorldUSecase extends App{



//     What we have is a list of credit cards and we'd like to calculate the premiums for all those cards that the credit card company has to pay out. The premiums themselves depend on the total number of credit cards, so that the company adjust them accordingly.

// We already have a function that calculates the premium for a single credit card and takes into account the total cards the company has issued:

case class CreditCard(creditInfo: CreditCardInfo, issuer: Person, account: Account)

object CreditCard {
  def getPremium(totalCards: Int, creditCard: CreditCard): Double = { ... }
}

// Now a reasonable approach to this problem would be to map each credit card to a premium and reduce it to a sum. Something like this:

val creditCards: List[CreditCard] = getCreditCards()
val allPremiums = creditCards.map(CreditCard.getPremium).sum //type mismatch; found : (Int, CreditCard) ⇒ Double required: CreditCard ⇒ ?

// However the compiler isn't going to like this, because CreditCard.getPremium requires two parameters. Partial application to the rescue! We can partially apply the total number of credit cards and use that function to map the credit cards to their premiums. All we need to do is curry the getPremium function by changing it to use multiple parameter lists and we're good to go.

// The result should look something like this:

object CreditCard {
  def getPremium(totalCards: Int)(creditCard: CreditCard): Double = { ... }
}

val creditCards: List[CreditCard] = getCreditCards()

val getPremiumWithTotal = CreditCard.getPremium(creditCards.length)_

val allPremiums = creditCards.map(getPremiumWithTotal).sum

}