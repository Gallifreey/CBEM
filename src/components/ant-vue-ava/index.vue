<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container">
    <div v-html="insightDom" style="display: flex"></div>
  </div>
</template>
<script lang="ts" setup>
import { InsightInfo, InsightVisualizationSpec, ParagraphSpec, PatternInfo, PhraseSpec, TextParagraphSpec, getInsights } from '@antv/ava'

const data = ref();
const insightDom = ref<string>("");
const getMyInsights = async () => {
fetch('https://cdn.jsdelivr.net/npm/vega-datasets@2.2.0/data/gapminder.json')
  .then((res) => res.json())
  .then((data) => {
    if (data) {
      const insightResult = getInsights(data, {
        limit: 10,
        measures: [
          { fieldName: 'life_expect', method: 'MEAN' },
          { fieldName: 'pop', method: 'SUM' },
          { fieldName: 'fertility', method: 'MEAN' },
        ],
        visualization: {
          lang: 'zh-CN'
        },
        insightTypes: ['time_series_outlier', 'trend'],
      });
      data.value = insightResult.insights;
      console.log(data.value)
      insightDom.value = getSentence(insightResult.insights)
    }
  });
};
const getSentence = (visSpecs: InsightInfo<PatternInfo>[]) => {
  let str = ''
  visSpecs.forEach((insight: InsightInfo<PatternInfo>) => {
    if(insight.visualizationSpecs){
      insight.visualizationSpecs.forEach((vis: InsightVisualizationSpec) => {
        if(vis.narrativeSpec) str += phaseNarrativeSpec(vis.narrativeSpec);
      })
    }
  })
  return str
}
const phaseNarrativeSpec = (narrativeSpec: ParagraphSpec[]) =>{
  let str = ''
  narrativeSpec.forEach((spec: ParagraphSpec) => {
    str += phaseSpecicalSpec(spec.type, spec)
  })
  return str
}
const phaseSpecicalSpec = (type: string, spec: ParagraphSpec) => {
  let str = ''
  switch(type) {
    case 'normal':
      str += phaseNormalSpec(spec)
  }
  return str
}
const phaseNormalSpec = (spec: TextParagraphSpec) => {
  let str = ''
  spec.phrases.forEach((phrase: PhraseSpec) => {
    switch(phrase.type) {
      case 'text':
        str += `<div class="insight-text" style="display: flex">${phrase.value}</div>`
        break
      case 'entity':
        str += `<div class="insight-text" style="display: flex">${phrase.value}</div>`
    }
  })
  return str
}
onMounted(() => {
  getMyInsights()
})
</script>
<style scoped>

</style>