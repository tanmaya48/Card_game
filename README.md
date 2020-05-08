# Card_game
A playable card game with simulated players


The way this works is, each turn a card is randomly drawn from a deck, the suit of the first card decides the prize suit

each drawn card either goes into the prize pool or on the table depending on whether it is from the prize suit

after each turn the players decide whether they want to leave or continue playing in this round. If one player leaves, they take all the prize with them and also remove one card from the table. 

If N players leave and there are M prize cards :

if N > M : no one takes any prize card
if N <= M : each player takes M/N prize cards randomly with M%N prize cards remaining in the deck

In each case, players also remove one card from the table.

The round ends when two cards with the same value, not of the prize set are on the table...
At that point all prize pool and table cards go back into the deck, and the round begins again...

The cards removed in each round remain out of the deck until there are less than 20 cards in the deck at which point the game ends

The players with the most prize value wins
Cards have their face value with J,Q,K,A being 11,12,13,14
