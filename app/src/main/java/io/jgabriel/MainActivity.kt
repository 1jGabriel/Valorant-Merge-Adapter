package io.jgabriel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDataInRecyclerView()
    }

    private fun setupDataInRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MergeAdapter()
        adapter.addAdapter(HeaderAdapter(Header()))
        DataSource.getCharacters().forEach {
            adapter.addAdapter(PersonageAdapter().apply {
                swapData(listOf(it))
            })

            adapter.addAdapter(SpellAdapter().apply {
                swapData(it.spells)
            })
        }
        adapter.addAdapter(BannerAdapter().apply {
            swapData(listOf(DataSource.getBanner()))
        })

        recyclerView.adapter = adapter
    }
}

data class Header(
    val id: Int = 0,
    val title: String = "Valorant",
    val subtitle: String = "FPS tático da RIOT"
)

data class Personage(
    val id: Int = 0,
    val name: String = "",
    val avatar: String = "",
    val description: String = "",
    val spells: List<Spell> = emptyList()
)

data class Spell(
    val id: Int = 0,
    val name: String = "",
    val description: String = ""
)

data class Banner(
    val banner: Int = 1
)

object DataSource {

    fun getCharacters() = ArrayList<Personage>().apply {
        add(
            Personage(
                id = 1,
                name = "Raze",
                avatar = "https://cdn.ome.lt/cz7gvc_tc7o2PV9N59YH8GJrB4M=/770x0/smart/uploads/conteudo/fotos/raze.jpg",
                description = "A personagem brasileira de Valorant é também a especialista em explosivos no game. " +
                    "Suas três habilidades básicas giram em torno desse tipo de munição, e seu Ultimate equipa nada menos que um lançador de foguetes.",
                spells = listOf(
                    Spell(
                        name = "Blast Pack",
                        description = "Lança uma bomba que gruda em superfícies, similar a C4. É possível detonar a carga remotamente."
                    ),
                    Spell(
                        name = "Paint Shells",
                        description = "Joga granadas de tinta que se dividem em fragmentos menores, causando dano aos inimigos próximos."
                    ),
                    Spell(
                        name = "Boom Bot",
                        description = "Ativa um robô que persegue inimigos e explode ao chegar próximo o suficiente deles."
                    ),
                    Spell(
                        name = "Showstopper",
                        description = "Equipa um lançador de foguetes."
                    )
                )
            )
        )
        add(
            Personage(
                2,
                "Breach",
                "https://cdn.ome.lt/UNu3em75j2efFGdqZHTRg4hG1XQ=/770x0/smart/uploads/conteudo/fotos/breach.jpg",
                "Sueco, Breach usa a força bruta para causar dano por trás de paredes e em altas quantidades.",
                listOf(
                    Spell(
                        name = "Aftershock",
                        description = "Equipa uma carga explosiva que atinge os inimigos por trás de paredes."
                    ),
                    Spell(
                        name = "Flashpoint",
                        description = "Carga que pode cegar os inimigos que estão atrás de uma parede."
                    ),
                    Spell(
                        name = "Fault Lines",
                        description = "Explosão sísmica que atordoa os inimigos na zona de ação."
                    )
                    ,
                    Spell(
                        name = "Rolling Thunder",
                        description = "Explosão sísmica que atordoa e dá dano aos adversários atingidos."
                    )
                )
            )
        )
        add(
            Personage(
                3,
                "Phoenix",
                "https://cdn.ome.lt/WnLzeb5TZ9oAoIKFXcdQlY-B5g8=/770x0/smart/uploads/conteudo/fotos/phoenix_KMr7bry.jpg",
                "Como o próprio nome já aponta, Phoenix é o mais “esquentadinho” dos heróis de Valorant. Natural do Reino Unido, o personagem usa o fogo como principal instrumento de combate.\n" +
                    "\n", listOf(
                    Spell(
                        name = "Curveball",
                        description = "Uma espécie de flashbang curva. Após lançar essa pequena bolinha de fogo, é possível curvar sua trajetória com o mouse."
                    ),
                    Spell(
                        name = "Blaze",
                        description = "Invoca uma parede de chamas que dá dano àqueles que a ultrapassarem."
                    ),
                    Spell(
                        name = "Hot Hands",
                        description = "Joga uma bola de fogo que explode ao bater no chão, dando dano a inimigos e curando a sua própria barra de vida."
                    ),

                    Spell(
                        name = "Run it Back",
                        description = "Marca sua localização atual e permite que o jogador renasça nela imediatamente após ser abatido."
                    )
                )
            )
        )
        add(
            Personage(
                4,
                "Viper",
                "https://cdn.ome.lt/X5hIwb9CpADoVZISQBwadUJ6lEg=/770x0/smart/uploads/conteudo/fotos/viper_yQFUraH.jpg",
                "A agente estadunidense tem o veneno como grande arma, utilizando toxinas como ferramenta de dano e também para dominar espaços do mapa.\n" +
                    "\n", listOf(
                    Spell(
                        name = "Snakebite",
                        description = "Lança um projétil que, ao explodir, vira uma poça de ácido."
                    ),
                    Spell(
                        name = "Poison Cloud",
                        description = "Deixa um emissor de gás que pode ser ativado remotamente."
                    ),
                    Spell(
                        name = "Toxic Screen",
                        description = "Permite a criação de uma parede de toxinas."
                    ),
                    Spell(
                        name = "Viper’s Pit",
                        description = " Uma grande nuvem de toxinas que permanece ativa enquanto Viper está dentro dela. A personagem consegue ver os inimigos com maior facilidade dentro da nuvem."
                    )
                )
            )
        )
        add(
            Personage(
                5,
                "Sova",
                "https://cdn.ome.lt/Q-NQq1bkwbjE7sqSXoY_AX20KBA=/770x0/smart/uploads/conteudo/fotos/sova.jpg",
                "De origem russa, Sova consegue identificar a posição dos inimigos com suas habilidades, e seu Ultimate tem alto poder destrutivo.\n" +
                    "\n",
                listOf(
                    Spell(
                        name = "Shock Bolt",
                        description = "Um arco e flecha elétrico, que infringe dano ao entrar em contato com o inimigo."
                    ),
                    Spell(
                        name = "Owl Drone",
                        description = " Drone de reconhecimento que atira em inimigos para revelar sua posição."
                    ),
                    Spell(
                        name = "Recon Bolt",
                        description = "Flecha que revela a posição dos inimigos próximos."
                    ),
                    Spell(
                        name = "Hunter’s Fury",
                        description = "Atire até três dardos de energia que atravessam paredes e dão alto dano aos adversários."
                    )
                )
            )
        )
        add(
            Personage(
                6,
                "Omen",
                "https://cdn.ome.lt/K1weNVe0Nr_2BC6K6RC8pZVgMt0=/770x0/smart/uploads/conteudo/fotos/omen.jpg",
                "Com todo o visual de Ravena dos Jovens Titãs, Omen usa a escuridão ao seu favor, seja para identificar inimigos ou para teletransportar.\n" +
                    "\n", listOf(
                    Spell(
                        name = "Paranoia",
                        description = "Emite uma sombra que reconhece os inimigos próximos."
                    ),
                    Spell(
                        name = "Shadow Walk",
                        description = "Permite teletransportes em distâncias curtas."
                    ),
                    Spell(
                        name = "Dark Cover",
                        description = "Orbe sombrio que explode ao chegar em seu destino final."
                    ),
                    Spell(
                        name = "From the Shadows",
                        description = "Permite teletransporte para qualquer lugar do mapa. Caso seu personagem morra no processo, ele volta ao lugar original. Se o teletransporte for completo com sucesso, Omen fica invulnerável por alguns momentos."
                    )
                )
            )
        )
        add(
            Personage(
                7,
                "Sage",
                "https://cdn.ome.lt/YlsI5mYVK2pXgNZz8F7cGKBIm3A=/770x0/smart/uploads/conteudo/fotos/sage.jpg",
                "A campeã chinesa tem habilidades que a enquadram numa função de suporte, facilitando o trabalho dos companheiros mais focados em dano.\n" +
                    "\n", listOf(
                    Spell(
                        name = "Slow Orb",
                        description = "Invoca um orbe que enraíza os inimigos, deixando-os mais lentos e provocando barulho quando eles se movimentam."
                    ),
                    Spell(
                        name = "Barrier Orb",
                        description = "Constrói uma grande barreira no cenário."
                    ),
                    Spell(
                        name = "Healing Orb",
                        description = "Permite curar seu companheiro de time ou a si mesmo por alguns segundos."
                    ),
                    Spell(
                        name = "Ressurection",
                        description = "Ressuscita um companheiro abatido e deixa-o com a vida completa."
                    )
                )
            )
        )
        add(
            Personage(
                8,
                "Brimstone",
                "https://cdn.ome.lt/uYa97hO1YfbHeW0cfKWjePhV_u8=/770x0/smart/uploads/conteudo/fotos/brimstone.jpg",
                "Com foco em habilidades de suporte, apenas a Ultimate do estadunidense Brimstone infringe dano " +
                    "direto aos adversários.",
                listOf(
                    Spell(
                        name = "Incendiary",
                        description = "Basicamente, uma granda incendiária."
                    ),
                    Spell(
                        name = "Stim Beacom",
                        description = "Fornece fogo rápido aos companheiros que estão no campo de ação da habilidade."
                    ),
                    Spell(
                        name = "Sky Smoke",
                        description = "Selecione pontos do mapa para dropar bombas de fumaça que obstruirão a visão."
                    ),
                    Spell(
                        name = "Orbital Strike",
                        description = "Marque um lugar no mapa para chamar um ataque aéreo que infringe muito dano por vários segundos."
                    )
                )
            )
        )
        add(
            Personage(
                9,
                "Cypher",
                "https://cdn.ome.lt/zG1iijTEpMashMpjFlitG0W1I8c=/770x0/smart/uploads/conteudo/fotos/cypher.jpg",
                "Nascido no Marrocos, Cypher tem habilidades para identificar a posição de seus inimigos, podendo " +
                    "fazer a diferença na quantidade de informações acumulada na equipe.",
                listOf(
                    Spell(
                        name = "Trapwire",
                        description = "Uma armadilha entre duas paredes que mostra rapidamente o posicionamento do inimigo que ativá-la, além de atordoá-lo temporariamente."
                    ),
                    Spell(
                        name = "Cyber Cage",
                        description = "Cria uma jaula que deixa os inimigos mais lentos."
                    ),
                    Spell(
                        name = "Spycam",
                        description = "Uma câmera de espionagem que pode ser usada remotamente. Assim como o equipamento de Maestro em Rainbow Six Siege, a câmera também pode atirar nos oponentes."
                    ),
                    Spell(
                        name = "Neural Theft",
                        description = "Examina o corpo de inimigos abatidos para descobrir a posição dos outros adversários."
                    )
                )
            )
        )
        add(
            Personage(
                10,
                "Jett",
                "https://cdn.ome.lt/96LWB7wOCzRwsmXxTsIe07f5STo=/770x0/smart/uploads/conteudo/fotos/jett_QRY1MtZ.jpg",
                "A sul-coreana tem suas lâminas como principal trunfo, e também utiliza o próprio ar como maneira de se movimentar e afetar seus inimigos.",
                listOf(
                    Spell(
                        name = "Cloudburst",
                        description = "Uma névoa que embaça a visão ao entrar em contato com o inimigo. É possível curvar sua trajetória."
                    ),
                    Spell(
                        name = "Updraft",
                        description = "Usa o impulso do vento para atingir locais mais altos no cenário."
                    ),
                    Spell(
                        name = "Tailwind",
                        description = "Uma espécie de dash, movimentando a personagem com maior velocidade em uma direção específica."
                    ),
                    Spell(
                        name = "Blade Storm",
                        description = "Equipa várias lâminas que eliminam os inimigos com um headshot. Ao garantir um abate, o número de lâminas é restaurado para o máximo."
                    )
                )
            )
        )
    }

    fun getBanner() = Banner(R.drawable.banner_valorant)
}
