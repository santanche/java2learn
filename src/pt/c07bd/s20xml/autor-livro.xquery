http://www.ic.unicamp.br/~santanch/teaching/db/xml/livro-autor.xml

let $livroautor := doc('http://www.ic.unicamp.br/~santanch/teaching/db/xml/livro-autor.xml')
return $livroautor/catalogo/autores

let $livroautor := doc('http://www.ic.unicamp.br/~santanch/teaching/db/xml/livro-autor.xml')
return $livroautor/catalogo/livros

let $autorlivro := doc('http://www.ic.unicamp.br/~santanch/teaching/db/xml/autor-livro-referencia.xml')
for $a in ($autorlivro/catalogo/autores/autor),
    $l in ($autorlivro/catalogo/livros/livro)
where $a/@livroid = $l/@id
return {concat('Autor: ', data($a/@nome), ', Livro: ', data($l/@titulo))}

<AllKnows> {
let $doc := doc('http://www.ic.unicamp.br/~santanch/teaching/db/2014-1/xml/knows-20140328-1722.xml')
for $i in ($doc/AllKnows/Knows)
let $grupoPessoa := $i/@person
let $grupoColleague := $i/@colleague
group by $grupoPessoa, $grupoColleague
order by $grupoPessoa, $grupoColleague
return <Knows person="{$grupoPessoa}" colleague="{$grupoColleague}"/>
}
</AllKnows>

<AllLikesMusic> {
let $doc := doc('http://www.ic.unicamp.br/~santanch/teaching/db/2014-1/xml/likesMusic-20140328-1726.xml')
for $i in ($doc/AllLikesMusic/LikesMusic)
let $grupoPerson := $i/@person
let $grupoBandUri := $i/@bandUri
group by $grupoPerson, $grupoBandUri
order by $grupoPerson, $grupoBandUri
return <LikesMusic person="{$grupoPerson}" rating="{max($i/@rating)}" colleague="{$grupoBandUri}"/>
}
</AllLikesMusic>

