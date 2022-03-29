package com.gentlekboy.starmovie.data.model

import com.gentlekboy.starmovie.R

/**
 * Data class for Casts and crews shown on the Casts and crew Screen
 */
data class CastAndCrewModel(
    val id: Int,
    val realName: String,
    val movieName: String,
    val image: Int
)

val castAndCrewList = arrayListOf(
    CastAndCrewModel(
        1, "Keanu Reeves", "JOHN WICK", R.drawable.keanu_reeves
    ),
    CastAndCrewModel(
        2, "Halle Berry", "SOFIA", R.drawable.halle_berry
    ),
    CastAndCrewModel(
        3, "Laurence Fishburne", "BOWERY KING", R.drawable.laurence_lishburne
    ),
    CastAndCrewModel(
        4, "Mark Dacascos", "ZERO", R.drawable.mark_dacascos
    ),
    CastAndCrewModel(
        5, "Asia Kate Dillon", "ADJUDICATOR", R.drawable.asia_kate_dillon
    ),
    CastAndCrewModel(
        6, "Lance Reddick", "CHARON", R.drawable.lance_reddick
    ),
    CastAndCrewModel(
        7, "Anjelica Huston", "DIRECTOR", R.drawable.anjelica_huston
    ),
    CastAndCrewModel(
        8, "Margaret Daly", "Operator", R.drawable.margaret_daly
    ),
    CastAndCrewModel(
        9, "Jerome Flynn", "Berrada", R.drawable.jerome_flynn
    )
)