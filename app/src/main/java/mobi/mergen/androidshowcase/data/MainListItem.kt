package mobi.mergen.androidshowcase.data

import io.reactivex.functions.Action
import java.io.Serializable

data class MainListItem(var title: String,
                        var desc: String,
                        var clickAction: Action) : Serializable
