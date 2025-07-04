<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
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
