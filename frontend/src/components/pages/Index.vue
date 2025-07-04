<template>
  <v-container fluid>
    <v-row>
      <v-col v-for="(card, index) in cards" :key="index"
        cols="3"
      >
        <v-card
            :to="card.link"
            class="mx-auto pa-4"
            style="display: flex; flex-direction: column; align-items: center; justify-content: center;"
            outlined
        >
            <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; width: 100%; height: 100%;">
                <template v-if="card.img">
                    <v-img 
                        :src="card.img" 
                        alt="카드 이미지" 
                        style="width: 300px; height: 160px; margin-bottom: 16px;"
                    ></v-img>
                </template>
                <template v-else>
                    <v-icon style="margin-bottom: 16px;" color="primary" size="64">mdi-apps</v-icon>
                </template>
                <v-card-title style="text-align: center; width: 100%;">{{ card.text }}</v-card-title>
            </div>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "주택사업",
          link: "/housingProjects",
          img: '/house.png'
      },
      {
          text: "주택공급",
          link: "/houseSupplies",
      },
      {
          text: "모집공고",
          link: "/announcements",
      },
      {
          text: "청약접수",
          link: "/subscriptions",
      },
      {
          text: "모집공고 목록",
          link: "/getAnnouncements",
      },
      {
          text: "신청결과알림",
          link: "/notifications",
      },
      {
          text: "당첨자",
          link: "/winners",
      },
      {
          text: "청약당첨자 목록",
          link: "/winningDashboards",
      },
      {
          text: "입주정보",
          link: "/tenants",
      },
      {
          text: "유지보수",
          link: "/maintenances",
      },
      {
          text: "계약정보",
          link: "/contracts",
      },
      {
          text: "입주연장계약",
          link: "/extendContracts",
      },
      {
          text: "계약체결이력",
          link: "/contractDashboards",
      },
    ],
  }),
};
</script>
