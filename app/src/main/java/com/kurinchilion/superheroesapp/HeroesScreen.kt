package com.kurinchilion.superheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurinchilion.superheroesapp.model.Hero
import com.kurinchilion.superheroesapp.model.HeroesRepository

@Composable
fun SuperHeroItem(hero: Hero, modifier: Modifier = Modifier){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.elevation)
        ),
        modifier = modifier
    ) {
            Row(
                modifier = Modifier
                .padding(dimensionResource(R.dimen.padding))
                .height(dimensionResource(R.dimen.layout_height))
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(hero.nameRes),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(hero.descriptionRes),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(Modifier.width(16.dp))
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.nameRes),
                    modifier = modifier
                        .padding(dimensionResource(R.dimen.padding), 0.dp, 0.dp, 0.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
            }
        }

    }



@Composable
public fun HeroesList(heroesList: List<Hero>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(heroesList) { hero ->
            SuperHeroItem(
                hero = hero,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding), dimensionResource(R.dimen.list_padding))
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun SuperHeroItemPreview(){
    SuperHeroItem(Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
}

@Preview(showBackground = true)
@Composable
private fun HeroesListPreview(){
    HeroesList(heroesList = HeroesRepository.heroes, modifier = Modifier)
}